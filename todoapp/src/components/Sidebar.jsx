import React from 'react';


function Sidebar() {
    return (
        <aside
            className="position-fixed top-0 start-0 bottom-0 bg-light border-end p-5 d-flex flex-column gap-2 pl-2">

            <h5 className="mb-3">Meny</h5>

            <button type="button" className="btn btn-primary w-100">Dashboard</button>
            <button type="button" className="btn btn-secondary w-100">Users</button>
            <button type="button" className="btn btn-success w-100">Task</button>
            <button type="button" className="btn btn-danger w-100">Settings</button>
            <button type="button" className="btn btn-warning w-100 mt-auto">Logout</button>
        </aside>

    );
}

export default Sidebar;