export default function Filters({filter, setFilter}) {
    function setStatus(status) {
        setFilter(prev => ({...prev, status}))
    }

    function setPriority(priority) {
        setFilter(prev => ({...prev, priority}))
    }

    function setSearch(e) {
        setFilter(prev => ({...prev, search: e.target.value}))
    }

    return (
        <div className="card shadow-sm">
            <div className="card-body">
                <div className="mb-3">
                    <label className="form-label fw-semibold">Sök</label>
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Hitta uppgifter…"
                        value={filter.search}
                        onChange={setSearch}
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label fw-semibold">Status</label>
                    <div className="btn-group w-100">
                        <button
                            className={`btn btn-outline-primary ${filter.status === "all" ? "active" : ""}`}
                            onClick={() => setStatus("all")}
                        >
                            Alla
                        </button>
                        <button
                            className={`btn btn-outline-primary ${filter.status === "active" ? "active" : ""}`}
                            onClick={() => setStatus("active")}
                        >
                            Aktiva
                        </button>
                        <button
                            className={`btn btn-outline-primary ${filter.status === "completed" ? "active" : ""}`}
                            onClick={() => setStatus("completed")}
                        >
                            Klara
                        </button>
                    </div>
                </div>

                <div>
                    <label className="form-label fw-semibold">Prioritet</label>
                    <select
                        className="form-select"
                        value={filter.priority}
                        onChange={e => setPriority(e.target.value)}
                    >
                        <option value="all">Alla</option>
                        <option value="low">Låg</option>
                        <option value="medium">Medium</option>
                        <option value="high">Hög</option>
                    </select>
                </div>
            </div>
        </div>
    )
}
