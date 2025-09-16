import {useState, useMemo} from "react"
import Header from "./components/Header.jsx"
import Sidebar from "./components/Sidebar.jsx"
import TaskForm from "./components/TaskForm.jsx"
import TaskList from "./components/TaskList.jsx"

export default function App() {
    const [tasks, setTasks] = useState([])
    const [filter, setFilter] = useState({status: "all", search: "", priority: "all"})

    const filtered = useMemo(() => {
        return tasks.filter(t => {
            const matchStatus =
                filter.status === "all"
                    ? true
                    : filter.status === "completed"
                        ? t.completed
                        : filter.status === "active"
                            ? !t.completed
                            : true
            const matchPriority = filter.priority === "all" ? true : t.priority === filter.priority
            const matchSearch = (t.title + " " + (t.description || "")).toLowerCase().includes(filter.search.toLowerCase())
            return matchStatus && matchPriority && matchSearch
        })
    }, [tasks, filter])

    function addTask(task) {
        setTasks(prev => [...prev, {...task, id: crypto.randomUUID(), completed: false}])
    }

    function toggleComplete(id) {
        setTasks(prev => prev.map(t => (t.id === id ? {...t, completed: !t.completed} : t)))
    }

    function removeTask(id) {
        setTasks(prev => prev.filter(t => t.id !== id))
    }

    return (
        <div className="container-fluid">
            <div className="row">
                <aside className="col-12 col-md-3 bg-white border-end min-vh-100 p-3">
                    <Sidebar filter={filter} setFilter={setFilter}/>
                </aside>
                <main className="col p-4">
                    <Header/>
                    <div className="row g-4">
                        <div className="col-md-5">
                            <TaskForm addTask={addTask}/>
                        </div>
                        <div className="col-md-7">
                            <TaskList tasks={filtered} onToggleComplete={toggleComplete} onRemove={removeTask}/>
                        </div>
                    </div>
                </main>
            </div>
        </div>
    )
}
