import requests 
from flask import Flask, render_template, request
  
offset= 0
app = Flask(__name__)

@app.route("/", methods=['GET'])
def home():
        # api-endpoint 
    
    URL = "http://localhost:8080/"
    offset_status = request.args.get('offset')

    global offset
    if offset_status == "Next" : 
        offset = offset + 20
    elif offset_status == "Back":
        offset = offset - 20
    else: 
        offset = 0

    # defining a params dict for the parameters to be sent to the API 
    PARAMS = {'off':offset} 
    print(PARAMS)
    # sending get request and saving the response as response object 
    r = requests.get(url = URL, params=PARAMS )
    
    # extracting data in json format 
    data = r.json() 
    #print(data)

    return render_template('index.html', data=data )

if __name__ == "__main__":
    pass
