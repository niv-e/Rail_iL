#!/usr/bin/python
import subprocess

from flask import Flask, request

app = Flask("my_app1")


@app.route("/add")
def addition():
    if 'a' in request.args:
        a = int(request.args.get('a'))
    else:
        a = 0
    if 'b' in request.args:
        b = int(request.args.get('b'))
    else:
        b = 0
    return str(a) + ' + ' + str(b) + ' == ' + str(a + b) + '<br>' + "thanks" + '<br>'


@app.route("/sub")
def subtract():
    a = int(request.args.get('a'))
    b = int(request.args.get('b'))
    return str(a - b)



@app.route("/rail")
def rail_schedule():
    if 'outformat' in request.args:
        outformat = request.args.get('outformat')
    else:
        outformat = 'html'

    if 'dept' in request.args:
        dept = request.args.get('dept')
    else:
        dept = 'Tel aviva'

    if 'dest' in request.args:
        dest = request.args.get('dest')
    else:
        dest = 'Tel aviva'

    if 'time' in request.args:
        time = request.args.get('time')
    else:
        time = '12:00'

    return subprocess.check_output(["java", "-classpath", "/home/niv/Desktop/backup/Rail_iL/bin", "CheckValidRides",
                                    outformat, dept, dest, time])
#http:/rail?dept=Tel%20aviv&dest=Haifa&time=%2715:00%27

