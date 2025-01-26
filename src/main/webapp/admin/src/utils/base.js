const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm4a271/",
            name: "ssm4a271",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm4a271/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SSM的大学生创客平台的设计与实现"
        } 
    }
}
export default base
