import i18n from "i18next";
import { initReactI18next } from "react-i18next";
import en from "./translation/en.json";
import tr from "./translation/tr.json";


const resources = {
  en: {
    translation: en
  },
  tr: {
    translation: tr
  }
};

const userLang = localStorage.getItem("lang") || navigator.language || "en";

export const i18ninstance = i18n.use(initReactI18next)


  i18ninstance.init({
    resources,
    fallbackLng: userLang,

    interpolation: {
      escapeValue: false 
    }
  });

  export default i18n;