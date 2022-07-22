export function regularMatch(text){
    const regex = new RegExp("[a-zA-z]+://[^\\s]*");
    let a = regex.exec(text);
    if (a != null){
        let b = a[0].replace(")","");
        return b;
    }else{
        return null;
    }
}