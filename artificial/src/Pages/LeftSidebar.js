import React from 'react'

const LeftSidebar = () => {
    return (
        <div id="menu" class="relative px-30 col-span-2 rounded-lg p-4">
            <h1 class="font-bold text-lg lg:text-3xl bg-gradient-to-br from-white via-white/50 to-transparent bg-clip-text text-transparent">Dashboard<span class="text-indigo-400">.</span></h1>
            <p class="text-slate-400 text-sm mb-2">Welcome back,</p>
            <a href="#" class="flex flex-col space-y-2 md:space-y-0 md:flex-row mb-5 items-center md:space-x-2 hover:bg-white/10 group transition duration-150 ease-linear rounded-lg group w-full py-3 px-2">
            </a>
            <hr class="my-2 border-slate-700" />
            <div className="flex justify-center align-middle">
                <button className='text-purple-600'>new chat</button>
            </div>
            {/* user name and pic detail div  */}
            <div class="absolute bottom-0 left-0 right-0 w-auto py-8 pl-3 w-100%">
            {/* <hr className='w-100%' /> */}
                <div className='flex gap-4'>
                    <img src='' className='h-10 w-10' />
                    <p className='text-pink-700'>gopi9876</p>
                </div>
            </div>

        </div>
    )
}

export default LeftSidebar