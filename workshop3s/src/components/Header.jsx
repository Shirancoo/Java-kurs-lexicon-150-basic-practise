export default function Header() {
    return (
        <div className="mb-4">
            <h1 className="display-6 fw-bold mb-1 d-flex align-items-center gap-2">
                <i className="bi bi-check2-square"></i>
                To-Do Dashboard
            </h1>
            <p className="text-secondary mb-0">
                Lägg till uppgifter, markera som klara och håll koll via sidomenyn.
            </p>
        </div>
    )
}
