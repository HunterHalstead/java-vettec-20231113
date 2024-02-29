# Node JS Installation

To practice with JavaScript outside the browser, we will start to use a NodeJS to run our code in the IDE terminal instead of in a web browser. 

> [!NOTE]
> Node.js is an open-source and cross-platform JavaScript runtime environment. 

Node.js runs the V8 JavaScript engine, the core of Google Chrome, outside of the browser. So similar to Java which needs the Java Runtime Environment (JRE) to run, JavaScript needs a runtime environment. 

Traditionally, JavaScript was only run inside of web browsers, but these days it is also used for web servers were it runs inside of the NodeJS runtime environment.

## Download Instructions

To download NodeJS go to the download page [here](https://nodejs.org/en/download). You can use the Windows installer. Make sure to select the LTS (Long Term Support) version.

![NodeJS Downloads Page](./imgs/nodejs-install-0.png)
[NodeJS Widows Installer](https://nodejs.org/en/#home-downloadhead)

### Mac Installation

Or if you are on Mac and have homebrew, simply use the command:

```bash
brew install node
```

If you do not have homebrew, choose the appropriate installer from the NodeJS downloads page [here](https://nodejs.org/en/download):

![alt text](./imgs/nodejs-install-0.5.png)

### Windows Installer

For the Windows installer, just use the defaults of the walkthrough wizard until you get to the *Chocolately* package manager option, go ahead and select it to avoid extra manual steps.

1. Open your downloads and click on the .msi file to open the installation. wizard.

![alt text](./imgs/nodejs-install-1.5.png)

2. Select Next.

![Install NodeJS Wizard Step 1](./imgs/nodejs-install-1.png)

3. Accept the License Agreement and select Next.

![Install NodeJS Wizard Step 2](./imgs/nodejs-install-2.png)

4. Keep the default install location and select Next.

![Install NodeJS Wizard Step 3](./imgs/nodejs-install-3.png)

5. Keep the default features to  be installed. Notice, that NodeJS will install npm package manager as well. Select Next. 

![Install NodeJS Wizard Step 4](./imgs/nodejs-install-4.png)

6. Select the option to install Chocolatey package manager for Window. Otherwise, you will have to follow the instructions at the given link to install other dependencies needed for NodeJS (namely the current version of Python and the C++ build environment as described [here](https://github.com/nodejs/node-gyp#on-windows).) 

![Install NodeJS Wizard Step 5](./imgs/nodejs-install-5.png)

7. The installation process might take a coule minutes. When it is complete, select Next.

![Install NodeJS Wizard Step 6](./imgs/nodejs-install-6.png)

8. Select finish. This may trigger another window to open in order to install Chocolatey and the other dependencies NodeJS needs to run.

![Install NodeJS Wizard Step 7](./imgs/nodejs-install-7.png)

8. After selecting finish, if you opted to install Chocolately on Windows to install the other necessary dependencies, you should see another terminal window open. Press any key to get it started. It will chug away and you may see messages slightly different than the ones below depending on what you do or do not already have installed.

![Install NodeJS Wizard Step 8](./imgs/nodejs-install-8.png)

9. To continue press any key.

![Install NodeJS Wizard Step 9](./imgs/nodejs-install-9.png)

![Install NodeJS Wizard Step 12](./imgs/nodejs-install-12.png)

![Install NodeJS Wizard Step 12.5](./imgs/nodejs-install-12.5.png)

![Install NodeJS Wizard Step 13](./imgs/nodejs-install-13.png)

10. Leave the terminal window up for a several minutes to make sure it is done. Then go ahead and close it.

11. In a new terminal we can check if the installation was successful.

    To test that the installation of NodeJS and NPM has been successful, open a terminal and check the `npm` and `node` commands work by printing the version.

```bash
npm -v
node --version
```
    
You should see something similar to below.

![Install NodeJS Wizard Step 14](./imgs/nodejs-install-14.png)

That's it! You are now ready to develop JavaScript code.
