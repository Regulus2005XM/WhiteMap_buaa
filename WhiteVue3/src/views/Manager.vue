<template>
    <div class="manager">
      <h1>后台管理系统</h1>
      
      <section>
        <h2>用户管理</h2>
        <button @click="showUserForm = true">添加用户</button>
        
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>用户名</th>
              <th>邮箱</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="user in users" :key="user.id">
              <td>{{ user.id }}</td>
              <td>{{ user.username }}</td>
              <td>{{ user.email }}</td>
              <td>
                <button @click="editUser(user)">编辑</button>
                <button @click="deleteUser(user.id)">删除</button>
              </td>
            </tr>
          </tbody>
        </table>
        
        <div v-if="showUserForm">
          <h3>{{ editingUser ? '编辑用户' : '添加用户' }}</h3>
          <input v-model="formData.username" placeholder="用户名" />
          <input v-model="formData.email" placeholder="邮箱" />
          <button @click="saveUser">{{ editingUser ? '保存' : '添加' }}</button>
          <button @click="clearForm">取消</button>
        </div>
      </section>
  
      <section>
        <h2>帖子管理</h2>
        <button @click="showPostForm = true">添加帖子</button>
        
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>标题</th>
              <th>内容</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="post in posts" :key="post.id">
              <td>{{ post.id }}</td>
              <td>{{ post.title }}</td>
              <td>{{ post.content }}</td>
              <td>
                <button @click="editPost(post)">编辑</button>
                <button @click="deletePost(post.id)">删除</button>
              </td>
            </tr>
          </tbody>
        </table>
        
        <div v-if="showPostForm">
          <h3>{{ editingPost ? '编辑帖子' : '添加帖子' }}</h3>
          <input v-model="postFormData.title" placeholder="标题" />
          <textarea v-model="postFormData.content" placeholder="内容"></textarea>
          <button @click="savePost">{{ editingPost ? '保存' : '添加' }}</button>
          <button @click="clearPostForm">取消</button>
        </div>
      </section>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  
  export default {
    setup() {
      const users = ref([]);
      const posts = ref([]);
      const showUserForm = ref(false);
      const showPostForm = ref(false);
      const formData = ref({ username: '', email: '' });
      const postFormData = ref({ title: '', content: '' });
      const editingUser = ref(null);
      const editingPost = ref(null);
  
      // Mock data
      let userId = 1;
      let postId = 1;
  
      const addUser = (user) => {
        user.id = userId++;
        users.value.push(user);
      };
  
      const updateUser = (user) => {
        const index = users.value.findIndex(u => u.id === user.id);
        if (index !== -1) {
          users.value[index] = user;
        }
      };
  
      const deleteUser = (id) => {
        users.value = users.value.filter(user => user.id !== id);
      };
  
      const saveUser = () => {
        if (editingUser.value) {
          updateUser({ ...editingUser.value, ...formData.value });
          editingUser.value = null;
        } else {
          addUser({ ...formData.value });
        }
        clearForm();
      };
  
      const clearForm = () => {
        formData.value = { username: '', email: '' };
        showUserForm.value = false;
      };
  
      const editUser = (user) => {
        editingUser.value = user;
        formData.value = { username: user.username, email: user.email };
        showUserForm.value = true;
      };
  
      // Post functions
      const addPost = (post) => {
        post.id = postId++;
        posts.value.push(post);
      };
  
      const updatePost = (post) => {
        const index = posts.value.findIndex(p => p.id === post.id);
        if (index !== -1) {
          posts.value[index] = post;
        }
      };
  
      const deletePost = (id) => {
        posts.value = posts.value.filter(post => post.id !== id);
      };
  
      const savePost = () => {
        if (editingPost.value) {
          updatePost({ ...editingPost.value, ...postFormData.value });
          editingPost.value = null;
        } else {
          addPost({ ...postFormData.value });
        }
        clearPostForm();
      };
  
      const clearPostForm = () => {
        postFormData.value = { title: '', content: '' };
        showPostForm.value = false;
      };
  
      const editPost = (post) => {
        editingPost.value = post;
        postFormData.value = { title: post.title, content: post.content };
        showPostForm.value = true;
      };
  
      return {
        users,
        posts,
        showUserForm,
        showPostForm,
        formData,
        postFormData,
        editingUser,
        editingPost,
        saveUser,
        clearForm,
        deleteUser,
        editUser,
        savePost,
        clearPostForm,
        deletePost,
        editPost
      };
    }
  };
  </script>
  
  <style scoped>
  .manager {
    padding: 20px;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
  }
  table, th, td {
    border: 1px solid #ccc;
  }
  th, td {
    padding: 8px;
    text-align: left;
  }
  button {
    margin-left: 10px;
  }
  </style>