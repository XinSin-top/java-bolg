import axios from 'axios'
import { ElMessage } from 'element-plus'

const Axios_instance = axios.create({
  baseURL:'http://localhost:8000',
  timeout: 60000, 		      // 请求超时时间1分钟
  responseType: "json",
  withCredentials: false    // 是否允许带cookie这些
})

//响应拦截器
Axios_instance.interceptors.response.use(function (response){
  if(response.headers.token != null){
    window.localStorage.setItem("token",response.headers.token);
  }
  let status = response.data.status;
  if(status === 250 || status === 251){
    ElMessage.error("令牌错误请重新登录,或者联系管理员")
    window.localStorage.clear();
  }
  return response;
}),function (error){
  return Promise.reject(error);
}
//请求拦截器
Axios_instance.interceptors.request.use(function (config){
  let token = window.localStorage.getItem("token");
  if (token != null & token !== '' && token !== 'undefined'){
    config.headers["Access-Token"] = window.localStorage.getItem("token");
  }
  return config;
}),function (error){
  return Promise.reject(error);
}
export default Axios_instance;
