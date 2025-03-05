import React, { useEffect, useState } from 'react';
import { getTasks } from '../services/api';

const TaskList = () => {
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        getTasks()
            .then(response => setTasks(response.data))
            .catch(error => console.error("Error fetching tasks:", error));
    }, []);

    return (
        <div>
            <h2>Task List</h2>
            <ul>
                {tasks.map(task => (
                    <li key={task.id}>{task.title} - {task.completed ? "✅" : "❌"}</li>
                ))}
            </ul>
        </div>
    );
};

export default TaskList;
