import React from 'react'
import { assets } from '../assets/assets.js'
import { useNavigate } from 'react-router-dom'
function Menubar() {

    const navigate = useNavigate();
    return (
        <>
            <nav className='navbar bg-white px-5 py-4 d-flex justify-content-between align-items-center'>
                <div className="d-flex align-items-center gap-2">
                    <img src={assets.logo} alt="" width={32} height={32} />
                    <span className='fw-bold fs-4 text-dark'>SpringFusion</span>
                </div>
                <div className="btn btn-outline-dark rounded-pill px-3" onClick={() => navigate("/login")}>
                    Login <i className='bi bi-arrow-right ms-2'></i>
                </div>
            </nav>
        </>
    )
}

export default Menubar
