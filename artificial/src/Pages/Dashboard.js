import React from 'react'
import InputPrompt from '../Component/Dashboard/InputPrompt'
import LeftSidebar from '../Component/Dashboard/LeftSidebar'
import NewChat from '../Component/Dashboard/NewChat'


const Dashboard = () => {
    return (
        <>
            <div class="bg-black w-full h-screen text-slate-300 relative ">
                <div class="grid grid-cols-12 mx-auto gap-2 sm:gap-4 md:gap-6 lg:gap-1 xl:gap-1 max-w-100% h-full">
                    {/*=========================== left side box ================ */}
                    <LeftSidebar />

                    {/*=================== right side box===================  */}
                    <div id="content" class="bg-white/10 col-span-10 sm:col-span-9 rounded-lg m-3 p-4 relative align-middle justify-items-center">
                        {/*================= newChat div component ============= */}
                        <div className="w-full flex items-center justify-center">
                            <NewChat />
                        </div>
                        {/*================ conversation div component ================ */}

                        {/* ============input prompt div here ============= */}
                        <div className="absolute bottom-0 left-0 w-full flex items-center justify-center">
                            <InputPrompt />
                        </div>
                    </div>
                </div>


            </div>
        </>
    )
}

export default Dashboard