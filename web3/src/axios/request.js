import Axios from "./Axios";

export function login(datas){
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
    url: "/api/selectArticleUUID/" + uuid,
    method: "get",
    headers:{
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  });
}
export function tokenVerify(){
  return Axios({
    url: "/api/tokenVerify",
    method: "get",
    headers:{
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  });
}
export function addStar(id){
  return Axios({
    url: "/api/addStar",
    method: "get",
    headers:{
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    params:{"articleId":id}
  });
}
export function removeStar(id){
  return Axios({
    url: "/api/removeStar",
    method: "get",
    headers:{
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    params:{"articleId":id}
  });
}
export function addWatch(id){
  return Axios({
    url: "/api/addWatch",
    method: "get",
    headers:{
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    params:{"articleId":id}
  });
}
export function selectStar(){
  return Axios({
    url: "/api/selectStar",
    method: "get",
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  });
}