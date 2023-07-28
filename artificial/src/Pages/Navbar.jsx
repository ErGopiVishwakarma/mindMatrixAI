import React from 'react'

const Navbar = () => {
  return (
    <>
    <div className='flex justify-between items-center'>
        <div className="border-2 border-rose-600">
            <h1 className='text-white'>mindMatrix</h1>
        </div>
        <div className="border-2 border-rose-600 flex justify-between items-center">
          <h1 className='text-white'>Features</h1>
          <h1 className='text-white'>Teams</h1>
          <h1 className='text-white'>How To Use</h1>
          <h1 className='text-white'>Dashboard</h1>
        </div>
        
    </div>
    <div>
       <h1 className='text-white font-serif text-2xl font-semibold'>Explore the Posiibilities of AI interviewing</h1>
       <h1 className='text-white'>Enhancing Hiring Accuracy and Candidate Experience!!</h1>
    </div>
    </>
  )
}

export default Navbar