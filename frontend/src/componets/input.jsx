import React from "react";

function Input(props) {
  const { label, id,type,onChange } = props;

  return (
    <>
      <div className="mb-3 form-group">
        <label htmlFor={id} className="form-label">
          {label}
        </label>
        <input onChange={onChange} className="form-control" id={id} type={type} placeholder={`Lütfen ${label.toLowerCase()} giriniz`} />
      </div>
    </>
  );
}

export default Input;
