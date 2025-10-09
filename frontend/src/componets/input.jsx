import React from "react";

function Input(props) {
  const { label, id,type,onChange,errors } = props;

  return (
    <>
      <div className="mb-3 form-group">
        <label htmlFor={id} className="form-label mb-0">
          {label}
        </label>
        <input onChange={onChange} className={errors ? "form-control is-invalid" : "form-control"} id={id} type={type} placeholder={`Lütfen ${label.toLowerCase()} giriniz`} />
      </div>
      <div>
        {errors}
      </div>
    </>
  );
}

export default Input;
