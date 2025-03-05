import axios from 'axios';

const API_BASE_URL = "http://localhost:8080"; // Backend URL

// Fetch all tasks
export const getTasks = async () => {
    return await axios.get(`${API_BASE_URL}/tasks`);
};

// Add a new task
export const addTask = async (taskData) => {
    return await axios.post(`${API_BASE_URL}/tasks`, taskData);
};

// Fetch all expenses
export const getExpenses = async () => {
    return await axios.get(`${API_BASE_URL}/expenses`);
};

// Add a new expense
export const addExpense = async (expenseData) => {
    return await axios.post(`${API_BASE_URL}/expenses`, expenseData);
};
