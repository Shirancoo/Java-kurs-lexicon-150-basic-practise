const $ = s => document.querySelector(s);
const api = async (url, opts={}) => {
  opts.headers = Object.assign({'Content-Type':'application/json'}, opts.headers||{});
  opts.credentials = 'include';
  const res = await fetch(url, opts);
  if (!res.ok) throw await res.json().catch(()=>({error: res.statusText}));
  return res.json().catch(()=> ({}));
};

let state = { user:null, quests:[], progress:null };

function show(el){ el.classList.remove('d-none'); }
function hide(el){ el.classList.add('d-none'); }

/* ---------- Auth ---------- */
async function login(){
  const email=$('#email').value.trim(), password=$('#password').value;
  try{
    const data = await api('/api/auth/login',{method:'POST', body: JSON.stringify({email,password})});
    state.user=data;
    $('#userEmail').textContent=data.email;
    hide($('#authSection')); show($('#progressSection')); show($('#budgetSection')); show($('#questsSection'));
    await refreshAll();
  }catch(e){ $('#authMsg').textContent=e.error||'Fel vid inloggning'; }
}
async function registerUser(){
  const email=$('#email').value.trim(), password=$('#password').value, displayName=$('#displayName').value.trim();
  try{
    await api('/api/auth/register',{method:'POST', body: JSON.stringify({email,password,displayName})});
    $('#authMsg').textContent='Konto skapat! Logga in.';
  }catch(e){ $('#authMsg').textContent=e.error||'Fel vid registrering'; }
}
async function logout(){
  await fetch('/api/auth/logout',{method:'POST', credentials:'include'});
  state={ user:null, quests:[], progress:null };
  show($('#authSection')); hide($('#progressSection')); hide($('#budgetSection')); hide($('#questsSection'));
}
$('#loginBtn').addEventListener('click', login);
$('#registerBtn').addEventListener('click', registerUser);
$('#logoutBtn').addEventListener('click', logout);

/* ---------- Budget ---------- */
const expenses = $('#expenses');
function addExpenseRow(name='',amount=''){
  const wrapper = document.createElement('div');
  wrapper.className = 'row g-2 align-items-center';
  wrapper.innerHTML = `
    <div class="col-7"><input class="form-control exp-name" placeholder="Namn" value="${name}"></div>
    <div class="col-4"><input class="form-control exp-amount" type="number" min="0" placeholder="Belopp" value="${amount}"></div>
    <div class="col-1 d-grid"><button class="btn btn-outline-light btn-sm remove">✕</button></div>`;
  wrapper.querySelector('.remove').onclick = () => wrapper.remove();
  expenses.appendChild(wrapper);
}
$('#addExpense').addEventListener('click',()=>addExpenseRow());

async function calcBudget(){
  const income = parseInt($('#income').value||'0',10);
  const goal = parseInt($('#goal').value||'0',10);
  const names = [...document.querySelectorAll('.exp-name')];
  const amnts = [...document.querySelectorAll('.exp-amount')];
  const exp = names.map((n,i)=>({name:n.value.trim(), amount: parseInt(amnts[i].value||'0',10)})).filter(e=>e.name);
  try{
    const res = await api('/api/budget/calculate',{method:'POST', body: JSON.stringify({income, goal, expenses: exp})});
    $('#sumExp').textContent = res.sumExpenses + ' kr';
    $('#remaining').textContent = res.remaining + ' kr';
    $('#goalVal').textContent = goal + ' kr';
    const pct = Math.max(0, Math.min(100, res.progressPercent||0));
    $('#goalFill').style.width = pct + '%';
    $('#goalText').textContent = pct + '%';
    const chip = $('#statusChip');
    chip.className = 'badge ' + (res.status==='EXCEEDED' || res.status==='MET' ? 'text-bg-success':'text-bg-warning');
    chip.textContent = res.status;
    show($('#budgetResult'));
  }catch(e){ console.warn(e); }
}
$('#calcBtn').addEventListener('click', calcBudget);

/* ---------- Quests ---------- */
$('#addQuest').addEventListener('click', async ()=>{
  const title=$('#qTitle').value.trim();
  if(!title){ $('#questMsg').textContent='Titel saknas'; return; }
  const description=$('#qDesc').value.trim();
  const dueDate=$('#qDue').value || null;
  try{
    await api('/api/quests',{method:'POST', body: JSON.stringify({title, description, dueDate, completed:false})});
    $('#qTitle').value=''; $('#qDesc').value=''; $('#qDue').value='';
    await refreshQuests();
  }catch(e){ $('#questMsg').textContent=e.error||'Fel vid skapande'; }
});

function questLi(q){
  const li=document.createElement('li');
  li.className='quest-item d-flex justify-content-between align-items-center';
  li.innerHTML = `
    <div>
      <div class="fw-semibold">${q.title}</div>
      <div class="text-secondary small">${(q.description||'').substring(0,120)} ${q.dueDate? '• Förfallo: '+q.dueDate:''}</div>
    </div>
    <div class="d-flex gap-2">
      <button class="btn btn-outline-light btn-sm toggle">${q.completed?'Ångra':'Klar'}</button>
      <button class="btn btn-outline-danger btn-sm del">Ta bort</button>
    </div>`;
  li.querySelector('.toggle').onclick = async ()=>{
    const before = q.completed;
    await api('/api/quests/'+q.id+'/toggle-complete',{method:'PATCH'});
    await refreshQuests();
    if(!before){ confetti(); await refreshProgress(); }
  };
  li.querySelector('.del').onclick = async ()=>{
    await api('/api/quests/'+q.id,{method:'DELETE'});
    await refreshQuests(); await refreshProgress();
  };
  return li;
}
function renderQuests(){
  const active = state.quests.filter(q=>!q.completed);
  const done   = state.quests.filter(q=> q.completed);
  $('#countActive').textContent = active.length;
  $('#countDone').textContent   = done.length;
  const A=$('#listActive'), D=$('#listDone'); A.innerHTML=''; D.innerHTML='';
  active.forEach(q=>A.appendChild(questLi(q)));
  done.forEach(q=>D.appendChild(questLi(q)));
}
async function refreshQuests(){ state.quests = await api('/api/quests'); renderQuests(); }

/* ---------- Progress ---------- */
function renderProgress(){
  const p=state.progress; if(!p) return;
  $('#levelBadge').textContent = 'Lvl '+p.level;
  $('#xpFill').style.width = p.progressPercent + '%';
  $('#xpText').textContent = `${p.xpIntoLevel} / ${p.xpForNextLevel} XP`;
  $('#questStats').textContent = 'Klara quests: ' + p.completedQuests;
  const deg = Math.round((p.progressPercent||0) * 3.6);
  $('#xpRing').style.background = `conic-gradient(#4cc9f0 0deg, #7c5cff ${deg}deg, #0b1020 ${deg}deg)`;
  $('#xpPct').textContent = (p.progressPercent|0) + '%';
}
async function refreshProgress(){ state.progress = await api('/api/progress'); renderProgress(); }
async function refreshAll(){ await refreshQuests(); await refreshProgress(); }

/* ---------- Confetti ---------- */
function confetti(){
  const c=$('#confetti'); c.innerHTML='';
  for(let i=0;i<90;i++){
    const d=document.createElement('div'); d.className='dot';
    const size=6+Math.random()*10; d.style.width=d.style.height=size+'px';
    d.style.left=(Math.random()*100)+'%';
    d.style.top='-10px';
    d.style.background = ['#7c5cff','#00d1b2','#4cc9f0','#ffd166'][i%4];
    d.style.animationDelay=(Math.random()*0.2)+'s';
    c.appendChild(d);
  }
  c.classList.remove('d-none'); setTimeout(()=>c.classList.add('d-none'), 1300);
}

/* Defaults */
function seedExpenses(){
  addExpenseRow('Hyra','9400'); addExpenseRow('Mat','3500'); addExpenseRow('Transport','900');
}
seedExpenses();
// Demokonto för snabbtest
$('#email').value='demo@demo.se'; $('#password').value='demo';