import React from 'react'
import LeftSidebar from './LeftSidebar'

const Dashboard = () => {
    return (
        <>
            <div class="bg-black w-full h-screen text-slate-300 relative ">
                <div class="grid grid-cols-12 mx-auto gap-2 sm:gap-4 md:gap-6 lg:gap-1 xl:gap-1 max-w-100% h-full">
                    {/* left side box  */}
                    <LeftSidebar />

                    {/* right side box  */}
                    <div id="content" class="bg-white/10 col-span-10 rounded-lg m-3 p-4">
                        gopi
                    </div>
                </div>
            </div>
        </>
    )
}

export default Dashboard