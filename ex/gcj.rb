def compile code
  app = code.chomp(".java")

  system "gcj #{code} --main=#{app} -o #{app}"
end

ARGV.each do |code|
  compile code
end
