export default function TaskItem({task, onToggleComplete, onRemove}) {
    return (
        <div className="card shadow-sm">
            <div className="card-body d-flex justify-content-between align-items-start">
                <div>
                    <h5 className={`mb-1 ${task.completed ? "text-decoration-line-through" : ""}`}>
                        {task.title}
                    </h5>
                    {task.description && (
                        <p className="mb-2 text-secondary">{task.description}</p>
                    )}
                    <span className={`badge bg-${
                        task.priority === "high" ? "danger" :
                            task.priority === "medium" ? "warning text-dark" :
                                "success"
                    }`}>
            {task.priority}
          </span>
                </div>

                <div className="btn-group">
                    <button
                        className={`btn btn-sm ${task.completed ? "btn-success" : "btn-outline-success"}`}
                        onClick={() => onToggleComplete(task.id)}
                    >
                        <i className="bi bi-check2"></i>
                    </button>
                    <button
                        className="btn btn-sm btn-outline-danger"
                        onClick={() => onRemove(task.id)}
                    >
                        <i className="bi bi-trash3"></i>
                    </button>
                </div>
            </div>
        </div>
    )
}
