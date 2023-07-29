import React from 'react'
import logo from '../../Images/ai1.gif'
import { useSearchParams } from 'react-router-dom'

const NewChat = () => {
  const [params, searchParams] = useSearchParams()
  let a = params.getAll('user')
  console.log(a[0].split(",")[2])

    return (
        <div className=' flex flex-col sm:px-10 md:px-15 lg:px-40 gap-8'>
            <div className='px-10 border-1 border-gray-400 outline-1 border-solid h-10 flex flex-row justify-center align-top '>
                <h2 className="text-3xl text-orange-600 italic">Welcome</h2>
                {/* <img src='https://gifdb.com/images/high/waving-hand-dark-brown-sticker-5y9pump98br4evz9.gif' className='w-20 h-20' /> */}
            </div>
            <div className=' flex flex-row gap-10'>
                <img src={logo} className='w-10 h-10 rounded-full' />
                <p>AI revolutionizes industries, empowering automation and efficiency. Its potential to learn, adapt, and solve complex problems holds promise for a better future. Embracing AI responsibly, we unlock boundless opportunities for innovation and progress.</p>
            </div>
            <div className=' flex flex-row gap-10'>
                <img src={logo} className='w-10 h-10 rounded-full' />
                <p>AI revolutionizes industries, empowering automation and efficiency. Its potential to learn, adapt, and solve complex problems holds promise for a better future. Embracing AI responsibly, we unlock boundless opportunities for innovation and progress.</p>
            </div>
            <div className=' flex flex-row gap-10'>
                <img src={logo} className='w-10 h-10 rounded-full' />
                <p>AI revolutionizes industries, empowering automation and efficiency. Its potential to learn, adapt, and solve complex problems holds promise for a better future. Embracing AI responsibly, we unlock boundless opportunities for innovation and progress.</p>
            </div>
        </div>
    )
}

export default NewChat