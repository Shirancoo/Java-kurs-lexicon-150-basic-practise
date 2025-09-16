import Filters from "./Filters.jsx"

export default function Sidebar({filter, setFilter}) {
    return (
        <div>
            <h2 className="h5 mb-3 d-flex align-items-center gap-2">
                <i className="bi bi-kanban"></i>
                Översikt
            </h2>
            <Filters filter={filter} setFilter={setFilter}/>

            <hr className="my-4"/>

            <div className="small text-secondary">
                <p className="mb-2 fw-semibold">Tips</p>
                <ul className="ps-3 mb-0">
                    <li>Filtrera på status, prioritet och söktext.</li>
                    <li>Uppgifterna sparas bara medan sidan är öppen .</li>
                </ul>
            </div>
        </div>
    )
}
