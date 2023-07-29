import React from 'react'
import logo from '../../Images/ai1.gif'

const LeftSidebar = () => {
    return (
        <div id="menu" class="relative px-30  md:col-span-3 rounded-lg p-4 px-11 md:px-4  sm:hidden md:block hidden">
            <div className='flex flex-row gap-4 justify-center align-middle'>
                <img src={logo} className="h-12 w-12 rounded-full" />
                <h1 class="font-bold text-lg lg:text-2xl  text-orange-600 italic">mind matrix</h1>
            </div>

            <hr class="my-2 border-slate-700" />
            <div className="flex justify-center align-middle mt-5 py-2 border border-solid border-orange-800 pointer">
                <button className='text-gray-300'>new chat</button>
            </div>

            {/* chat history div here  */}



            {/* user name and pic detail div  */}

            <div class="absolute bottom-0 left-0 right-0 w-auto py-8 p-8 w-100% border-3 border-solid border-orange-500   ">
                <hr className='w-100% mb-8 bg-orange-600' />
                <div className='flex gap-4 flex-row justify-between '>
                    <div className='flex flex-row gap-4'>
                        <img src={logo} className="h-12 w-12 rounded-full" alt='gopi' />
                        <div className='flex flex-col text-sm'>
                            <p className='text-pink-700 text-sm'>gopi</p>
                            <p>gopi@gmail.com</p>
                        </div>
                    </div>
                    <button className='text-xl'>...</button>
                </div>
            </div>
        </div >
    )
}

export default LeftSidebar