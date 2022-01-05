import React from 'react'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    <header className='header'>
      <div>
        <Link className='links' to='/'>
          Home
        </Link>
      </div>

      <nav className='navbar'>
        <ul>
          <Link className='links' to='/login'>
            Admin
          </Link>

          <Link className='links' to='/search'>
            Search
          </Link>

          <Link className='links' to='/checkin'>
            Checkin
          </Link>

         
          
        </ul>
      </nav>
    </header>
  )
}

export default Header
