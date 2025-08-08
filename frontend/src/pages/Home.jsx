import React from 'react'

import Menubar from '../components/Menubar.jsx'
import Header from '../components/Header.jsx'

function Home() {
    return (

        <div className="flex flex-col items-center justify-content-center min-vh-100">
            <Menubar />
            <Header></Header>
        </div>
    )
}

export default Home
