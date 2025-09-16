import Header from './components/Header.jsx'
import Sidebar from './components/Sidebar.jsx'
import React from 'react';
import Line from "./components/Line.jsx";
import TodoForm from "./components/TodoForm.jsx";

function App() {
    return (
        <>
        <Header></Header>
            <Sidebar></Sidebar>
            <Line></Line>
            <TodoForm></TodoForm>
        </>
    )

}

export default App;
