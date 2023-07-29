import React, { useEffect, useState } from 'react'
import Navbar from './Navbar';
import '../Style/Homepage/home.css'
import Loading from '../Component/Dashboard/Loading';
import { useNavigate, useSearchParams } from 'react-router-dom';


const HomePage = () => {
  const navigate = useNavigate()
  const [loading, setLoading] = useState(false)
  const [searchParams, setSearchParams] = useSearchParams()
  const [render, setRender] = useState([])
  let data = searchParams.getAll('user') || ''
  const openAuth = () => {
    window.open(`https://ai-n1m9.onrender.com/auth/google/callback`, '_self')
  }

  const backendFun = () => {
    // if (searchParams.getAll('user')) {
    //   setLoading(true)
    //   alert(searchParams.getAll('user')[0]?.split(",") || 'hii my name is gopi')
    //   setTimeout(() => {
    //     setLoading(false)
    //     navigate('/chat')
    //   }, 3000)
    // } else {
    //   return
    // }
  }
  // alert(searchParams.getAll('user'))
  // useEffect(() => {
  //   backendFun()
  // }, [])

  // if (data) {
  //   setLoading(true)
  //   console.log(searchParams.getAll('user'))
  // }





  const radialGradient = {
    backgroundImage: 'radial-gradient(ellipse farthest-corner at center center, #0E0C15 0%, #2b1028 0%, #0E0C15 100%)'
  };

  const [isOpen, setIsOpen] = useState(false);

  const openModal = () => {
    setIsOpen(true);
  };

  const closeModal = () => {
    setIsOpen(false);
  };


  return (
    <div /*style={radialGradient}*/ className='h-screen radial-gradient-background aesthetic-background relative' >

      <Navbar />



      <div className='text-gray-300 font-semibold mt-5 text-5xl flex justify-center items-center mono fade-in'>
        <h1 className='text-4xl italic '>Explore the Possibilities</h1>
      </div>
      <div className='text-gray-300 font-semibold text-5xl flex justify-center items-center serif animated-text'>
        <h1 className='text-4xl italic '>of AI Interviewing with MindMatrix</h1>

      </div>
      <div className='text-white font-semibold mt-6 text-xl flex justify-center items-center serif animated-text'>
        <p>Enhance Hiring Accuracy and Candidate Experience!!</p>
      </div>
      <div className='flex  justify-center'>
        <button onClick={openAuth} className='transition  shadow-lg shadow-cyan-500/50 ease-in-out delay-150 drop-shadow-md hover:-translate-y-1 hover:scale-110 hover:bg-indigo-500 duration-300 mt-10 text-white p-3 rounded-tr-lg  bg-cyan-600 font-bold'>Login to continue</button>
      </div>

      {/*  ////////////// */}

      {
        isOpen && (
          <div className="fixed inset-0 flex items-center justify-center">
            <div className="absolute inset-0 bg-black bg-opacity-50"></div>
            <div className="bg-white p-4 rounded w-1/2">
              <h2 className="text-xl font-bold mb-2">Modal Title</h2>
              {isOpen && (
                <div className="fixed inset-0 flex items-center justify-center">
                  <div className="fixed inset-0 bg-black bg-opacity-50"></div>
                  <div className="bg-white p-4 rounded w-1/2">
                    <h2 className="text-xl font-bold mb-2">Modal Title</h2>
                    <button
                      className="absolute top-2 right-2 text-gray-500"
                      onClick={closeModal}
                    >
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        className="h-6 w-6"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                        aria-hidden="true"
                      >
                        <path
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          strokeWidth="2"
                          d="M6 18L18 6M6 6l12 12"
                        />
                      </svg>
                    </button>
                    {/* Your modal content */}
                    <p>
                      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                      tincidunt ante id erat venenatis, in dignissim mi egestas.
                    </p>
                    <p>
                      Mauris eget ex sed sem fermentum tincidunt a eget odio. Cras
                      posuere risus at lobortis convallis. Nunc vel eros id libero
                      pharetra vehicula eu vel mi.
                    </p>
                    <div className="flex justify-end mt-4">
                      <button
                        className="px-4 py-2 bg-blue-500 text-white rounded mr-3"
                        onClick={closeModal}
                      >
                        Close
                      </button>
                      <button className="px-4 py-2 text-blue-500 rounded border border-blue-500">
                        Secondary Action
                      </button>
                    </div>
                  </div>
                </div>
              )}
            </div>

          </div>
        )
      }

      {/* <Loading /> */}


      {/* ///////////// */}


      <div className='mt-10  flex justify-center items-center h-28'>
        <img src="https://t4.ftcdn.net/jpg/03/86/07/83/360_F_386078374_WDOvxzHmUCsg0h3AufqbhtuWkBKz8XpU.jpg" alt="robot-img" className='rounded-xl hover:shadow-indigo-500/40 ' />
      </div>
      <div>

      </div>
    </div>
  )
}

export default HomePage