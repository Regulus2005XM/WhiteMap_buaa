 <!-- 引入Bootstrap 3 CSS -->
 <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
 </link>
 <!-- 引入Font Awesome -->
 <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
 </link>
<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- —————————————————————————————————页面展示———————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
<template>
<body>
  <!-- 未登录状态 -->
  <div v-if="isLoggedIn=='false'">

    <el-col :sm="12" :lg="6">
      <el-result icon="error"
      title="登录以查看更多信息"sub-title="注册暂时无需手机号验证等">

      <template #extra>
        <el-button color="#626aef" @click="gotoreg()">现在注册</el-button>
        <el-button type="primary" @click="gotolog()">已有账号，立刻登录</el-button> 
      </template>
      </el-result>
    </el-col>
  </div>

  <!-- 已登录 -->
  <div v-else>
    <div class="container">
        <div class="info-card">
            <div class="profile-section">
                <div class="profile-img">
                    <i class="fa fa-user"></i>
                </div>
                <h2 class="text-primary">{{ params.data.account }} <span class="badge badge-custom">正式用户</span></h2>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="info-section">
                        <h3><i class="fa fa-info-circle"></i> 个人信息</h3>
                        <div class="info-item">
                            <p><i class="fa fa-user"></i>用户id：{{ params.data.id }}</p>
                        </div>
                        <div class="info-item">
                            <p><i class="fa fa-id-card"></i>用户账号：{{ params.data.account }}</p>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="info-section">
                        <h3><i class="fa fa-graduation-cap"></i>绑定信息</h3>
                        <div class="info-item">
                            <p><i class="fa fa-university"></i>邮箱：{{ params.data.email }}</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="description">
                <h3><i class="fa fa-file-text"></i>个人简介</h3>
                <p class="lead"></p>
                <ul class="list-group">
                    <li class="list-group-item"><i class="fa fa-check text-success"></i>{{ params.data.discription }}</li>
                    <li class="list-group-item"><i class="fa fa-check text-success"></i></li>
                </ul>
            </div>

            <h2 class="welcome-title">欢迎回来！</h2>
            <el-button type="primary" class="logout-button" 
            @click="logout">登出</el-button>
        </div>
    </div>
    
  </div>
  </body>

</template>

<!-- ———————————————————————————————————————————————————————————————————————— -->
<!-- —————————————————————————————————代码逻辑———————————————————————————————— -->
<!-- ———————————————————————————————————————————————————————————————————————— -->
  
<script lang="ts" setup>

import { onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'
import { useRoute } from 'vue-router';
import axios from 'axios'

const user = ref(null);
const isLoggedIn = ref("false");
const route = useRoute();
const router = useRouter();
let params = ref("aaa");

function gotoreg(){
    router.push('/reg');
}
function gotolog(){
    router.push('/log');
}
const logout = () => {
  params.value = "had_logout"
  isLoggedIn.value = 'false'
}

onMounted(()=>{
  getJwts();
})
const getJwts = async () => {
  const jwt = localStorage.getItem('jwt');
  if (jwt) {
    const jwt0 = JSON.stringify(jwt);
    const response = await axios.post(
      "http://localhost:8080/userinfo",
      jwt0,
      {headers:{'Content-Type':'application/json'}});
    params.value = response.data;
    console.log(params.value);
    isLoggedIn.value = localStorage.getItem('isLog').valueOf();
  } else {
    params.value = "未获取到 JWT";
  }
}
</script>


<style scoped>
.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
.item {
    margin-top: 10px;
    margin-right: 30px;
}
.el-dropdown {
    margin-top: 1.1rem;
}
.user-profile {
  max-width: 400px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #dcdcdc;
  border-radius: 10px;
  background-color: #f9f9f9;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.welcome-title {
  text-align: center;
  color: #333;
}

.user-info-list {
  margin: 20px 0;
}

.el-list-item {
  padding: 10px;
  border-bottom: 1px solid #eee;
  font-size: 16px;
  color: #666;
}
.el-list-item strong {
  color: #333;
}
body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            padding-top: 50px;
            min-height: 100vh;
            
        }

        .info-card {
            background-color: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
            padding: 30px;
            margin: 20px auto;
            max-width: 800px;
            transition: transform 0.3s ease;
            max-width: 70vw;
        }

        .info-card:hover {
            transform: translateY(-5px);
        }

        .profile-section {
            text-align: center;
            padding: 20px 0;
            border-bottom: 2px solid #eee;
            margin-bottom: 30px;
        }

        .profile-img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            margin: 0 auto 20px;
            border: 5px solid #fff;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
            background-color: #f8f9fa;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .profile-img i {
            font-size: 80px;
            color: #764ba2;
        }

        .info-section {
            padding: 20px;
            background: #f8f9fa;
            border-radius: 10px;
            margin-bottom: 20px;
        }

        .info-item {
            margin: 15px 0;
            padding-left: 20px;
            border-left: 4px solid #764ba2;
        }

        .info-item i {
            margin-right: 10px;
            color: #764ba2;
        }

        .badge-custom {
            background-color: #764ba2;
            color: white;
            padding: 5px 10px;
            border-radius: 15px;
            margin-left: 10px;
        }

        .description {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
</style>