import { useState } from 'react'
import './App.css'
import { ToastContainer } from 'react-bootstrap'
import { Route, Routes } from 'react-router-dom'
import Home from './pages/Home.jsx'
import Login from './pages/Login.jsx'
import Emailverify from './pages/Emailverify.jsx'

import ResetPassword from './pages/ResetPassword.jsx'

function App() {
  return <>
    <ToastContainer>
    </ToastContainer>
    <Routes>
      <Route path='/' element={<Home></Home>}></Route>
      <Route path='/login' element={<Login></Login>}></Route>
      <Route path='/email-verify' element={<Emailverify></Emailverify>}></Route>
      <Route path='/reset-password' element={<ResetPassword></ResetPassword>}></Route>

    </Routes>
  </>
}

export default App
