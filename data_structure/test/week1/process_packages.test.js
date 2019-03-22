const fs = require('fs-extra')
const {shell} = require('execa')
const {resolve} = require('path')
const java = require('../java-compile')
const srcDir = java.srcDir('week1/network_packet_processing_simulation');
const fileName = 'process_packages'
const srcFile = resolve(srcDir, `${fileName}.java`)
fdescribe(fileName, () => {
    let i = 0;
    beforeAll(() => {
        java.compile(srcFile);
    })
    java.getTests(srcFile).forEach((test, idx) => {
        if(idx <= 25 && idx >= 0){
            it(`test case ${test.fileName}: should return ${test.answer}`, async () => {
                const a = await shell(`java -Xmx1024m ${fileName} `, {
                    cwd: java.root + '/gen',  
                    input: test.input,
                    encoding: 'utf8'
                })
                const calculated = a.stdout.split(/\r?\n\r?/gm).filter(a => a)
                const answer = test.fullAnswer.split(/\n/gm).filter(a=>a) 
                expect(calculated).toEqual(answer)

            }, 1500)
        }
    })
})
