import React from 'react'
import Input from '../../componets/input'

function SingUp() {
  return (
    <>
    <Input label='Kullanici Adi' id='name'/>
    <Input label='E Posta' id='email'/>
    <Input label='Sifre' id='password'/>
    <Input label='Sifre Tekrar' id='rePassword'/>
    <button className='btn btn-primary'>Kayit Ol</button>
    </>
  )
}

export default SingUp