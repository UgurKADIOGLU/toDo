import { useTranslation } from "react-i18next";

function LanguageSelector() {
  const { i18n } = useTranslation();

  const onSelectLanguage = (language) => {
    i18n.changeLanguage(language);
    localStorage.setItem("lang", language);
  };
  return (
    <>
      <img
        role="button"
        src="https://flagcdn.com/24x18/tr.png"
        width="32"
        height="24"
        alt="Turkiye"
        onClick={() => onSelectLanguage("tr")}
      ></img>
      <img
        role="button"
        src="https://flagcdn.com/24x18/us.png"
        width="32"
        height="24"
        alt="England"
        onClick={() => onSelectLanguage("en")}
      ></img>
    </>
  );
}

export default LanguageSelector;
