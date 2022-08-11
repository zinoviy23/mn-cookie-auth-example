## Cookies test

### Setup hosts

Check if there no `sashkinsite.com` in `/etc/hosts`:
```bash
cat /etc/hosts
```

If they are go to the next section. If not:
```bash
sudo -- sh -c  'echo "# For testing\n127.0.0.1 sashkinsite.com\n127.0.0.1 user.sashkinsite.com" >> /etc/hosts'
```

### Testing
Execute requests from [./cookies.http](cookies.http)