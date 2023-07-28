import React from 'react'
import Navbar from './Navbar';
// import '../Style/Homepage/home.css'

const HomePage = () => {
    const radialGradient = {
        backgroundImage: 'radial-gradient(ellipse farthest-corner at center center, #0E0C15 0%, #2b1028 0%, #0E0C15 100%)'
      };
  return (
   <div style={radialGradient} className='h-screen'>

  <Navbar/>
     {/* <button className='bg-violet-500 hover:bg-violet-700 active:bg-violet-700 focus:outline-none focus:ring focus:ring-violet-300 px-4 py-1 rounded-full text  -gray.100'>Login</button> */}
       
        {/* <div className='flex justify-center items-center'>  */}

          {/* <div className="relative top-2 border-2 border-slate-800 w-3/6 rounded-lg">
             <img className='rounded-md' src='https://assets.gatesnotes.com/8a5ac0b3-6095-00af-c50a-89056fbe4642/11eeb7f9-7512-49aa-abdc-a27001dd123e/AI_20230215_article-hero_1200x564.jpg'/>
             </div>
             <div  className="absolute top-13 border-2 border-rose-600 w-2/6 rounded-lg">
            <img className='rounded-md' src='https://assets.gatesnotes.com/8a5ac0b3-6095-00af-c50a-89056fbe4642/11eeb7f9-7512-49aa-abdc-a27001dd123e/AI_20230215_article-hero_1200x564.jpg'/>
         </div> */}
    
        

        {/* </div> */}
  
   </div>
  )
}

export default HomePage