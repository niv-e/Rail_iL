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

    if 'iStaion' in request.args:
        istaion = request.args.get('iStaion')

    if 'fStaion' in request.args:
        fstaion = request.args.get('fStaion')

    if 'time' in request.args:
        time = int(request.args.get('time'))

    if '0' in request.args:
        return "check seccsses"

    else:
        outformat = "html"
    return subprocess.check_output(["java", "-classpath", "../Rail_iL/bin", "CheckValidRides",
                                    outformat ,istaion , fstaion, time])


#app.run(port=8005, host="0.0.0.0")