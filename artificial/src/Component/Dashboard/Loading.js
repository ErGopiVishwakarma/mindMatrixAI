import React from 'react'

const Loading = () => {


    return (
        <div class="flex justify-center items-center h-screen absolute top-0 left-0 right-0 bottom-0 bg-slate-900 bg-opacity-80">
            <div class="spinner flex flex-col gap-3 ">
                <div className='flex flex-row gap-5 '>
                    <div class="dot w-12 h-12 rounded-full bg-orange-600 animate-pulse animation-delay-100 "></div>
                    <div class="dot w-12 h-12 rounded-full bg-orange-700 animate-pulse  animation-delay-200 "></div>
                    <div class="dot w-12 h-12 rounded-full bg-orange-800  animate-pulse animation-delay-100  "></div>
                </div>
                <h1 className='text-white text-center text-2xl'>Redirecting.....</h1>
            </div>
        </div>

    )
}

export default Loading