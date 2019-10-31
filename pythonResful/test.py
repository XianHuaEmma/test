from flask import Flask, request, jsonify
import json
app = Flask(__name__)
@app.route('/v1/sendGraph', methods=['POST'])
def hello_world():
    if not request.data:
        return ("fail");
    # 获取到POST过来的数据，因为我这里传过来的数据需要转换一下编码。根据晶具体情况而定
    graphresult = request.data.decode('utf-8')
    # 把区获取到的数据转为JSON格式
    graphresult_json = json.loads(graphresult)
    ## kgRes = graphresult_json.get("kgResult")
    #返回json数据
    ##return jsonify(graphresult_json)
    kgRes = graphresult_json["kgResult"]
    data = kgRes["data"]
    info = data[0]
    str1 = ''
    for key in info:
        if key == 'name':
            str1 = str1 + str(info[key])+'\r\n'
            ##str1.join(info[key]).join('\r\n')
        else:
            str1 = str1 + key + ':' + str(info[key])+'\r\n'
            ##str1.join(key).join(info[key]).join('\r\n')

    return str1
if __name__ == '__main__':
    ##app.run(host='192.168.1.154',port=1234)
    app.run()