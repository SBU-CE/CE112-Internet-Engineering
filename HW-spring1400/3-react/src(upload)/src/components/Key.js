const Key = ({ onClick, text, wide, blue }) => {
  return (
    <button
      onClick={onClick}
      className={["key", wide && "wide", blue && "blue"].join(" ")}
    >
      {text}
    </button>
  );
};

export default Key;
