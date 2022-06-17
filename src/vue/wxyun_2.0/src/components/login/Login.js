
import axios from "../../http/http.js"
import CryptoJS from "crypto-js";
export default {
    name:"Login",

    data() {
        var checkName = (rule, value, callback) => {
            if (!value) {
                return callback(new Error('用户名不能为空'));
            }
            // setTimeout(() => {
            //     if (!Number.isInteger(value)) {
            //         callback(new Error('请输入数字值'));
            //     } else {
            //         if (value < 18) {
            //             callback(new Error('必须年满18岁'));
            //         } else {
            //             callback();
            //         }
            //     }
            // }, 1000);
        };
        var validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'));
            } else {
                if (this.ruleForm.checkPass !== '') {
                    this.$refs.ruleForm.validateField('checkPass');
                }
                callback();
            }
        };
        var validatePass2 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.ruleForm.pass) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
        return {
            ruleForm: {
                pass: '',
                checkPass: '',
                name: ''
            },
            rules: {
                pass: [
                    { validator: validatePass, trigger: 'blur' }
                ],
                checkPass: [
                    { validator: validatePass2, trigger: 'blur' }
                ],
                name: [
                    { validator: checkName, trigger: 'blur' }
                ]
            }
        };
    },
    methods: {
        encrypt(word, keyStr,ivStr) {
            // 判断是否存在keyStr，不存在就用默认的keyStr（注意：这个keyStr必需要前后端统一，不然双方加密解密后会不相同。调用generatekey方法生成）
            keyStr = keyStr ? keyStr : "1grLx91U40VawzhRAm7E";
            let key = CryptoJS.enc.Utf8.parse(keyStr);
            let iv = CryptoJS.enc.Utf8.parse(ivStr);
            let srcs = CryptoJS.enc.Utf8.parse(word);
            let encrypted = CryptoJS.AES.encrypt(srcs, key, {
                iv:iv,
                mode: CryptoJS.mode.CBC,
                padding: CryptoJS.pad.Pkcs7
            });
            return encrypted.toString();
            // return CryptoJS.enc.Base64.stringify(encrypted.ciphertext);
        },

        submitForm(formName) {
            console.log("deng lu")
            var user = {};
            user.username=this.ruleForm.name;
            this.encrypt(this.ruleForm.pass,"Gao2022cm0312dai","Gao2022cm0312dcd")
            user.password = this.ruleForm.pass;
            axios.post("/user/login", JSON.stringify(user)).then(result => {
                console.log(result)
                if( result.data.code === 0){
                    this.$router.push("home")
                } else {
                    alert("账号密码错误")
                }
            }).catch(ex => {
                console.log(ex)
            })



            // this.$refs[formName].validate((valid) => {
            //     if (valid) {
            //         alert('submit!');
            //     } else {
            //         console.log('error submit!!');
            //         return false;
            //     }
            // });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}