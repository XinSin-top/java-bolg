import Axios from "./Axios";

export function Login(datas){
  return Axios({
    url: "/api/login",
    method: "post",
    headers:{
      "Content-Type" : 'application/json'
    },
    data: datas
  });
}
export function uploadImages(file){
  return Axios({
    url:"/api/upload/images",
    method: 'post',
    data:file
  })
}
export function saveArticle(datas){
  return Axios({
    url: "/api/saveArticle",
    method: "post",
    headers:{
      "Content-Type" : 'application/json'
    },
    data: datas
  });
}
export function selectArticle(){
  return Axios({
    url: "/api/selectArticle",
    method: "get",
    headers:{
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  });
}
export function selectArticleUUID(uuid){
  return Axios({
    url: "/api/selectArticle/" + uuid,
    method: "get",
    headers:{
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  });
}