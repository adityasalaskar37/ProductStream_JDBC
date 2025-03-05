import React, { useState } from 'react';
import { addTask } from '../services/api';

const AddTask = () => {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        addTask({ title, description, completed: false })
            .then(() => {
                alert("Task added!");
                setTitle("");
                setDescription("");
            })
            .catch(error => console.error("Error adding task:", error));
    };

    return (
        <div>
            <h2>Add Task</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Task Title" value={title} onChange={(e) => setTitle(e.target.value)} required />
                <input type="text" placeholder="Description" value={description} onChange={(e) => setDescription(e.target.value)} required />
                <button type="submit">Add Task</button>
            </form>
        </div>
    );
};

export default AddTask;
