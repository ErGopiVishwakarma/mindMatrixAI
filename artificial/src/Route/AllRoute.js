import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Dashboard from '../Pages/Dashboard'
import HomePage from '../Pages/HomePage'

const AllRoute = () => {
    return (
        <Routes>
            <Route path='/' element={<HomePage />} />
            <Route path='/chat' element={<Dashboard />} />
        </Routes>
    )
}

export default AllRoute