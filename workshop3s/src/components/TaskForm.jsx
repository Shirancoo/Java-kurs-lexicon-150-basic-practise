import {useState} from "react"

export default function TaskForm({addTask}) {
    const [title, setTitle] = useState("")
    const [description, setDescription] = useState("")
    const [priority, setPriority] = useState("medium")

    function onSubmit(e) {
        e.preventDefault()
        if (!title.trim()) return
        addTask({title, description, priority})
        setTitle("")
        setDescription("")
        setPriority("medium")
    }

    return (
        <div className="card shadow-sm">
            <div className="card-body">
                <h3 className="h5 mb-3 d-flex align-items-center gap-2">
                    <i className="bi bi-plus-circle"></i>
                    Lägg till uppgift
                </h3>
                <form onSubmit={onSubmit}>
                    <div className="mb-3">
                        <label className="form-label">Titel <span className="text-danger">*</span></label>
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Vad ska göras?"
                            value={title}
                            onChange={e => setTitle(e.target.value)}
                            required
                        />
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Beskrivning</label>
                        <textarea
                            className="form-control"
                            rows="3"
                            placeholder="Valfritt…"
                            value={description}
                            onChange={e => setDescription(e.target.value)}
                        ></textarea>
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Prioritet</label>
                        <select
                            className="form-select"
                            value={priority}
                            onChange={e => setPriority(e.target.value)}
                        >
                            <option value="low">Låg</option>
                            <option value="medium">Medium</option>
                            <option value="high">Hög</option>
                        </select>
                    </div>

                    <button type="submit" className="btn btn-primary w-100">
                        <i className="bi bi-plus-lg me-2"></i>Lägg till
                    </button>
                </form>
            </div>
        </div>
    )
}
