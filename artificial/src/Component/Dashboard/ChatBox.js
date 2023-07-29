import React from 'react'
import logo from '../../Images/ai1.gif'

const ChatBox = () => {
    return (
        <div className='flex flex-col'>
            {/*================= when user ask question  =================*/}
            <div className=' flex flex-row gap-10 px-32 py-7'>
                <img src={logo} className='w-10 h-10 rounded-full' />
                <p>gopi revolutionizes industries, empowering automation and efficiency. Its potential to learn, adapt, and solve complex problems holds promise for a better future. Embracing AI responsibly, we unlock boundless opportunities for innovation and progress.</p>
            </div>
            {/*================== when gpt response ================== */}
            <div className=' flex flex-row gap-10 bg-white/10 px-32 py-7'>
                <img src={logo} className='w-10 h-10 rounded-full'  />
                <p>AI revolutionizes industries, empowering automation and efficiency. Its potential to learn, adapt, and solve complex problems holds promise for a better future. Embracing AI responsibly, we unlock boundless opportunities for innovation and progress.</p>
            </div>
            <div className=' flex flex-row gap-10 px-32 py-7'>
                <img src={logo} className='w-10 h-10 rounded-full' />
                <p> revolutionizes industries, empowering automation and efficiency. Its potential to learn, adapt, and solve complex problems holds promise for a better future. Embracing AI responsibly, we unlock boundless opportunities for innovation and progress.</p>
            </div>
            <div className=' flex flex-row gap-10 bg-white/10 px-32 py-7'>
                <img src={logo} className='w-10 h-10 rounded-full'  />
                <p>AI revolutionizes industries, empowering automation and efficiency. Its potential to learn, adapt, and solve complex problems holds promise for a better future. Embracing AI responsibly, we unlock boundless opportunities for innovation and progress.</p>
            </div>
            <div className=' flex flex-row gap-10  px-32 py-7'>
                <img src={logo} className='w-10 h-10 rounded-full' />
                <p>AI revolutionizes industries, empowering automation and efficiency. Its potential to learn, adapt, and solve complex problems holds promise for a better future. Embracing AI responsibly, we unlock boundless opportunities for innovation and progress.</p>
            </div>
            <div className=' flex flex-row gap-10 bg-white/10 px-32 py-7'>
                <img src={logo} className='w-10 h-10 rounded-full'  />
                <p>AI revolutionizes industries, empowering automation and efficiency. Its potential to learn, adapt, and solve complex problems holds promise for a better future. Embracing AI responsibly, we unlock boundless opportunities for innovation and progress.</p>
            </div>
         
        </div>
    )
}

export default ChatBox