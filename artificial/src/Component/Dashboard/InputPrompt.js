import React from 'react'
// import { VscSend } from 'react-icons/vsc'

const InputPrompt = () => {
    return (

        <div class="absolute w-3/4 bottom-4 inset-x-auto">
            <input  id="default-search" class="block w-full p-3 pl-10 text-sm 
            rounded-lg bg-white/10 dark:bg-gray-700 dark:placeholder-gray-400 
            dark:text-white focus:outline-none text-white" placeholder="send a message" required />

            <button type="submit" class="text-white absolute right-2.5 bottom-1.5 px-4 py-2 ">
                {/* <VscSend /> */}
            </button>
        </div>
    )
}

export default InputPrompt