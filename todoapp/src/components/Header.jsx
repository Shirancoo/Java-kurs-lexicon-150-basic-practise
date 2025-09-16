import React from 'react';
import './Header.css';

function Header() {
    return (
        <header className="ms-10p position-absolute top-0 start-0  cursive ">

            <h1 className="h5 position-sticky  ">Task</h1>

            <form className="search-form">
                <input
                    type="text"
                    className="form-control"
                    placeholder="Sök."
                />
            </form>


        </header>
    );
}

export default Header;
