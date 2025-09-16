import TaskItem from "./TaskItem.jsx"

export default function TaskList({tasks, onToggleComplete, onRemove}) {
    if (!tasks.length) {
        return (
            <div className="alert alert-light border d-flex align-items-center">
                <i className="bi bi-inbox me-2"></i>
                Inga uppgifter ännu.
            </div>
        )
    }

    return (
        <div className="d-flex flex-column gap-3">
            {tasks.map(task => (
                <TaskItem
                    key={task.id}
                    task={task}
                    onToggleComplete={onToggleComplete}
                    onRemove={onRemove}
                />
            ))}
        </div>
    )
}
