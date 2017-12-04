# Vbox 虚拟机 ubuntu 共享主机文件夹
## 环境

1. 主机 Windows
2. 虚拟机 ubuntu

## 解决方案

1. 在vbox里设置共享文件夹
2. 在ubuntu执行下面的命令

```
sudo mkdir /mnt/share  
sudo mount -t vboxsf file  /mnt/share 

其中 file 是 Windows下的文件夹名

```