import React from 'react'

function Input(props) {
    const {label, id} = props;

  return (
    <>
    <div className='mb-3'>
        <label htmlFor={id} className='form-label'>{label}</label>
         <input id={id} type="text" placeholder='Enter your task' />
    </div>
   
    </>
  )
}

export default Input