import axios from"axios";
import { i18ninstance } from '../locales';

const http=axios.create();

http.interceptors.request.use((config)=>{
    config.headers["Accept-Language"]=i18ninstance.language;
    return config;})
    
export default http;